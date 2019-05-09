<#macro menu>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <a class="navbar-brand" href="/">AskTask</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">Mainstream</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/userPosts">My Posts</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/addPost">Add Post</a>
                </li>
                <li class="nav-item">
                    <form action="/logout" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Sign Out"/>
                    </form>
                </li>
            </ul>
        </div>
    </nav>
</#macro>