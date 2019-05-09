<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<#import "parts/menu.ftl" as m>

<@c.page "Add Post">
    <@m.menu />
    <form action="/posts" enctype="multipart/form-data" method="post" style="margin-top: 10%;">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <div class="form-group row">
            <label for="inputEmail3" class="col-sm-2 col-form-label">Title</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail3" name="title" placeholder="Title" />
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword3" class="col-sm-2 col-form-label">Description</label>
            <div class="col-sm-10">
                <input type="text" maxlength="1000" class="form-control" id="inputPassword3" name="description" placeholder="Description" />
            </div>
        </div>
        <div class="custom-file">
            <input type="file" name="file" class="custom-file-input" id="customFileLang" lang="es">
            <label class="custom-file-label" for="customFileLang">Select image</label>
        </div>
        <div class="form-group row">
            <div class="col-sm-10">
                <input type="submit" style="margin-top: 5%;" class="btn btn-primary" value="Add"/>
            </div>
        </div>
    </form>
</@c.page>