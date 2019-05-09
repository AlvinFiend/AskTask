<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page "Sign In">
    <@l.login "/login" "Sign In" />
    <b><a href="/registration">Sign Up</a></b>
</@c.page>