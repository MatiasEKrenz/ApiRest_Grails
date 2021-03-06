<%--
  Created by IntelliJ IDEA.
  User: mkrenz
  Date: 2019-04-24
  Time: 11:15
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html style="font-family: sans-serif; line-height: 1.15;">
<head>

    <title></title>
    <script type="text/javascript">
        function changeSite (id){
            if(id) {
                url = '${createLink(controller:'client', action: 'changeSite')}/' + id;
                fetch(url)
                    .then(function(response) {
                        return response.text();
                    }).then(function(data) {
                    categorias = JSON.parse(data.substring(14, data.length-1));
                    content = document.getElementById('categories');
                    content.innerHTML = "";
                    document.getElementById('subcategories').innerHTML="";

                    table = document.createElement('div');
                    table.style = 'border-collapse: collapse; padding: 15px;';
                   // tr = document.createElement('tr');
                    th = document.createElement('th');
                    th.style =  "padding: 8px; text-align: left; border-bottom: 1px solid #ddd;";
                    th.innerText = "Root";
                    //tr.appendChild(th);
                    table.appendChild(th);
                    //table.appendChild(tr);
                    categorias.map( function callback(currentValue) {
                        /*tr = document.createElement('tr');
                        td = document.createElement('td');*/
                        td = document.createElement('li');
                        td.style =  "padding: 8px; text-align: left;";
                        button = document.createElement('a');
                        //button.type = "button"
                        button.style = "cursor: pointer";
                        button.addEventListener('click', function(){
                            selectCategory(currentValue.id);
                        }, false);
                        button.innerText = currentValue.name;
                        /*td.appendChild(button);
                        tr.appendChild(td);
                        table.appendChild(tr);*/
                        table.appendChild(td);
                        td.appendChild(button);
                    });
                   // tr = document.createElement('tr')
                    content.appendChild(table);

                });
            }
        }

        function selectCategory(idCategory){
            if(idCategory) {
                url = '${createLink(controller:'client', action: 'selectCategory')}/' + idCategory;
                fetch(url)
                    .then(function(response) {
                        return response.text();
                    }).then(function(data) {

                    subcategorias = JSON.parse(data.substring(17, data.length-1));
                    content = document.getElementById('subcategories');

                    subcategoria = document.getElementById('subcategoria' + subcategorias.path_from_root.length);


                    if(subcategoria == null){
                        subcategoria = document.createElement('div');
                        subcategoria.id = 'subcategoria' + subcategorias.path_from_root.length;
                        subcategoria.style = "border-radius: 10px; border: 1px solid rgb(170, 170, 170); margin-left: 15px;";
                    }else{
                        subcategoria.innerHTML = "";
                        for (var i = subcategorias.path_from_root.length; i <= content.childElementCount; i++) {
                            document.getElementById('subcategoria' + i).innerHTML = "";
                        }
                    }


                    if(subcategorias.children_categories.length == 0) {
                        alert('categoria: ' + subcategorias.name + ' id: ' + subcategorias.id);
                    }else{
                        table = document.createElement('div');
                       // table.style = 'border-collapse: collapse; padding: 15px; margin-left: 20px auto;';
                        table.style = 'border-collapse: collapse; padding: 15px; margin-left: 20px auto;';
                      //  tr = document.createElement('tr');
                        //th = document.createElement('th');
                        th = document.createElement('th');
                        th.style =  "padding: 8px; text-align: left; border-bottom: 1px solid #ddd;"
                        th.innerText = subcategorias.name;
                        //tr.appendChild(th);
                        table.appendChild(th);
                        subcategorias.children_categories.map( function callback(currentValue) {
                           // tr = document.createElement('tr');
                            td = document.createElement('li');
                            td.style =  "padding: 8px; text-align: left;";
                            button = document.createElement('a');
                           // button.type = "button"
                            button.style = "cursor: pointer";
                            button.addEventListener('click', function(){
                                selectCategory(currentValue.id);
                            }, false);
                            button.innerText = currentValue.name;
                            /*td.appendChild(button);
                            tr.appendChild(td);
                            table.appendChild(tr);*/

                            table.appendChild(td);
                            td.appendChild(button);

                        });
                       // tr = document.createElement('tr')
                        subcategoria.appendChild(table);
                    }
                    content.appendChild(subcategoria);

                });
            }
        }
    </script>
</head>
<body>
<h1> Categorías Mercado Libre</h1>
<g:select name="sites.name" from="${sites}"
          optionKey="id"
          optionValue="name"
          onchange="changeSite(this.value);"/>
<div style="display: flex">
    <div id="categories" style="border-radius: 10px; border: 1px solid rgb(170, 170, 170);">

    </div>
    <!--<div id="subcategories" style="display: flex; border-radius: 10px; border: 1px solid rgb(170, 170, 170);" > -->
        <div id="subcategories" style="display: flex; " >

    </div></div>
</body>
</html>