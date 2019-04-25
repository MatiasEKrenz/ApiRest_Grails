package apirest_grails

import grails.rest.Resource

// esta categoria se va a exponer como recurso
//el readOnly = true, solo me deja hacer GET y no agregar bi modificar nada
@Resource(formats = ['json', 'xml'])

class Category {

    String name
    String description
    Site site

    //static hasMany = [items: Item]


    //static belongsTo = [site:Site]

    //tengo que autogenerar los controllers para hacer filtros y que no me salgan todos los items de todas las categorias

    static constraints = {
        // esto es suficiente para que grails persista en la base de datos
        name blank: false, nullable: false
        description blank: false, nullable: false
    }
}
