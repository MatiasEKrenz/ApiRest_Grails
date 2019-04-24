import apirest_grails.Category
import apirest_grails.Item
import apirest_grails.Site
import grails.rest.render.json.JsonRenderer

// Place your Spring DSL code here
beans = {
    //si no quiero que el json me tire el ID
    categoryRenderer(JsonRenderer, Category){
        excludes = ['id']
    }

    itemRenderer(JsonRenderer, Item){
        excludes = ['id']
    }

    siteRenderer(JsonRenderer, Site){
        excludes = ['id']
    }
}
