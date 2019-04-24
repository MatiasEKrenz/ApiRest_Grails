package apirest_grails

class UrlMappings {

    static mappings = {
       /* "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }*/

        "/sites"(resources: "site"){
            "/categories"(resources: "category"){
                "/items"(resources: "item")
            }
        }

        "/"(controller: "Client") //aca llamamos al controlador con cierto uri
        //"/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
