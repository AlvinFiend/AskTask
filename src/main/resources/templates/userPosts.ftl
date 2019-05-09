<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#import "parts/menu.ftl" as m>

<@c.page "My Posts">
    <@m.menu />
    <div style="margin-top: 10%;">
    <#list posts as post>
        <div class="card post" style="margin: 2% 0; padding: 2%;">
            <h5 class="card-title text-center">${post.title}</h5>
            <#if post.filename??>
                <img class="card-img-top img-thumbnail img-fluid" name="user-post" src="/users/img/${post.filename}" alt="${post.title}">
            </#if>
            <div class="card-body">
                <p class="card-text">${post.description}</p>
            </div>
            <form action="posts/${post.id}" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="REMOVE" />
            </form>
        </div>
    <#else>
        <b>No posts</b>
    </#list>
    </div>
</@c.page>