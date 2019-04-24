package apirest_grails

import grails.rest.Resource

@Resource(formats = ['json', 'xml'])

class Site {

    String name

    static constraints = {
        name blank: false, nullable: false
    }
}
