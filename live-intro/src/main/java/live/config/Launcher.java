package live.config;

import org.apache.catalina.*;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.tomcat.JarScanFilter;
import org.apache.tomcat.JarScanType;

import javax.servlet.ServletException;
import java.io.File;
import java.util.regex.Pattern;

public class Launcher {
  static final String PREFIX = "live-intro/";
  static final String JAR_NAME = "live-intro.*";

  public static void startTomcat() {
    try {
      new TomcatLauncher(PREFIX).start();
    } catch (Exception e) {
      throw new RuntimeException("Cannot start Tomcat container", e);
    }
  }

  static class TomcatLauncher {
    String prefix = "";

    TomcatLauncher() {
    }

    TomcatLauncher(String prefix) {
      this.prefix = prefix;
    }

    void start() throws ServletException, LifecycleException {
      long timeBegin = System.currentTimeMillis();

      String contextPath = "/";
      String webAppDirLocation = prefix + "src/main/webapp/";
      String baseDirectory = new File(webAppDirLocation).getAbsolutePath();

      Tomcat tomcat = new TomcatWithFastStartup();
      tomcat.setPort(8080);
      StandardContext context = (StandardContext) tomcat.addWebapp(contextPath, baseDirectory);

      // Additions to make @WebServlet work
      String buildPath = prefix + "target/classes";
      String webAppMount = "/WEB-INF/classes";

      File additionalWebInfClasses = new File(buildPath);
      WebResourceRoot resources = new StandardRoot(context);
      resources.addPreResources(
          new DirResourceSet(resources, webAppMount, additionalWebInfClasses.getAbsolutePath(), contextPath));
      context.setResources(resources);
      // End of additions

      tomcat.start();
      long timeEnd = System.currentTimeMillis();
      System.out.println("Started server on port 8080 (" + (timeEnd - timeBegin) + " ms)");

      tomcat.getServer().await();
    }
  }

  // We disable jarscan as we stay in the IDE
  static class TomcatWithFastStartup extends org.apache.catalina.startup.Tomcat {
    private Pattern[] allowedPatterns = new Pattern[]{
        Pattern.compile("jstl.*"),
        Pattern.compile(JAR_NAME),
        Pattern.compile("spring-web.*")};

    @Override
    public void start() throws LifecycleException {
      for (Service service : getServer().findServices()) {
        for (Container container : service.getContainer().findChildren()) {
          for (Container c : container.findChildren()) {
            ((Context) c).getJarScanner().setJarScanFilter(new JarScanFilter() {
              @Override
              public boolean check(JarScanType jarScanType, String jarName) {
                for (Pattern each : allowedPatterns) {
                  if (each.matcher(jarName).matches()) {
                    return true;
                  }
                }
                return false;
              }
            });
          }
        }
      }
      super.start();
    }
  }
}

