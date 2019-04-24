package apirest_grails

import grails.rest.Resource
// para ponerlo como recurso
// uri = "/items" es la uri
@Resource(formats = ['json', 'xml'])

class Item {

    Category category
    String name
    double price
    String subtitle
    String imageUrl



    static constraints = {
        name blank: false, nullable: false
        price max: 1000D, min: 1D
        subtitle blank: false, nullable: false
        imageUrl blank: false, nullable: false
    }
}
