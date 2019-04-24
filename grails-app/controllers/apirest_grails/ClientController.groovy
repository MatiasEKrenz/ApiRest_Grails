package apirest_grails

import groovy.json.JsonSlurper

class ClientController {

    // aca podemos crear metodos con diferentes gsp, ver ejemplo anterior
    def index() {
        def url = new URL("https://api.mercadolibre.com/sites")
        def connection = (HttpURLConnection) url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept", "application/json")
        connection.setRequestProperty("User-Agent", "Mozilla/5.0")
        JsonSlurper json = new JsonSlurper()
        def result = json.parse(connection.getInputStream())
        [result: result]
    }

    def cate(){
        def url = new URL("https://api.mercadolibre.com/sites/MLA/categories")
        def connection = (HttpURLConnection) url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept", "application/json")
        connection.setRequestProperty("User-Agent", "Mozilla/5.0")
        JsonSlurper json = new JsonSlurper()
        def result2 = json.parse(connection.getInputStream())
        [result2: result2]
    }

    //action="cate" id="${site.id}"
    //<option value="${site.id}" data-foo="${site.slug}">${site.name}</option>
}
