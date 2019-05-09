<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page "Registration">
    <b>${message!}</b>
    <@l.login "/registration" "Sign Up"/>
    <b><a href="/login">Back</a></b>
</@c.page>