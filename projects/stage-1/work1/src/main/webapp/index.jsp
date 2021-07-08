<%@ taglib prefix="cr" uri="/WEB-INF/common-response.tld" %>
<html>
<head>
    <title>A sample custom tag</title>
</head>
<body>
<cr:response-header cacheControl="no-cache" pragma="no-cache" expires="-1"/>
<div>
    <div>custom tags configuration <strong>response header attribute</strong></div>
    <ul>
        <li><strong>Cache-Control:no-cache</strong></li>
        <li><strong>Pragma:no-cache</strong></li>
        <li><strong>Expires:-1</strong></li>
    </ul>
</div>
</body>

</html>
