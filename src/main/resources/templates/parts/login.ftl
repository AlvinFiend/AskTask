<#macro login path button_name>
    <img class="logo" src="/static/img/ask-task.png" style="margin: 10% 0;" />

    <form action="${path}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div class="form-group row">
            <div class="col-sm-10">
                <input type="text" class="form-control" style="width: 300px;" id="inputEmail3" name="username" placeholder="Username" />
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-10">
                <input type="password" class="form-control" style="width: 300px;" id="inputPassword3" name="password" placeholder="Password">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-10">
                <input type="submit" class="btn btn-primary" value="${button_name}"/>
            </div>
        </div>
    </form>
</#macro>