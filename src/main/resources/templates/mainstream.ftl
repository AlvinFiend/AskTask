<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#import "parts/menu.ftl" as m>

<@c.page "Mainstream">
    <div>
        <@m.menu />
    </div>
    <br/>
    <div>
        <form class="form-inline" style="margin-top: 100px;" method="get" action="/">
            <input class="form-control mr-sm-2" style="width: 89%;" type="text" name="filter" value="${filter!}"
                   placeholder="Search"/>
            <input class="btn btn-outline-success my-2 my-sm-0" style="width: 10%;" type="submit" value="Search"/>
        </form>
    </div>
    <br/>
    <#list posts as post>
        <div class="card post" style="margin: 2% 0; padding: 2%;">
            <h5 class="card-title text-center">${post.title}</h5>
            <h6 class="card-subtitle mb-2 text-muted">Posted by : ${post.authorName}</h6>
            <#if post.filename??>
                <img class="card-img-top img-thumbnail img-fluid" name="user-post" src="/users/img/${post.filename}"
                     alt="${post.title}">
            </#if>
            <div class="card-body">
                <p class="card-text">${post.description}</p>
            </div>
        </div>
    <#else>
        <b>No posts</b>
    </#list>
</@c.page>
