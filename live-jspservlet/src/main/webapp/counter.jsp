<%@ page import="foo.*, java.util.*" %>

<html>
<body>
<%! int count=0; %>

<%! int doubleCount() {
    count = count*2;
    return count;
}
%>

The page count is:
<%= ++count %>
</body>
</html>