package apirest_grails

import grails.converters.*
import groovy.json.JsonSlurper
import grails.converters.JSON

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
        [sites: result]
    }

    def changeSite() {
        def url = new URL("https://api.mercadolibre.com/sites/" + params.id + "/categories")
        def connection = (HttpURLConnection) url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept", "application/json")
        connection.setRequestProperty("User-Agent", "Mozilla/5.0")
        JsonSlurper json = new JsonSlurper()
        def result = json.parse(connection.getInputStream())

        render ([categories: result as JSON])
    }

    def selectCategory(){
        def url = new URL("https://api.mercadolibre.com/categories/" + params.id)
        def connection = (HttpURLConnection) url.openConnection()
        connection.setRequestMethod("GET")
        connection.setRequestProperty("Accept", "application/json")
        connection.setRequestProperty("User-Agent", "Mozilla/5.0")
        JsonSlurper json = new JsonSlurper()
        def result = json.parse(connection.getInputStream())
        render ([subcategories: result as JSON])

    }


    //action="cate" id="${site.id}"
    //<option value="${site.id}" data-foo="${site.slug}">${site.name}</option>


    /*


    noSelection="['':'-Elija un país-']"





<label for="select"></label><select id="select">
    <g:each in="${result}" var="site" params="[param1: site.id]">
        <option value="${site.id}" data-foo="${site.slug}">${site.name} </option>
    </g:each>
</select>

<g:link controller="Client" action="list">
    <button type="button">Press me!!!</button>
</g:link>


<label for="select2"></label><select id="select2">
    <g:each in="${result}" var="site" >
        <option value="${site.id}" data-foo="${site.slug}">${site.name} </option>
    </g:each>
</select>










<form>
    <g:select
            optionKey="id" optionValue="name" name="site.name" id="site.name" from="${apirest_grails.Site.list()}"
            onchange="${remoteFunction(
                    controller:'Client',
                    action:'ajaxGetCities',
                    params:'\'id=\' + escape(this.value)',
                    onSuccess:'updateCity(data)')}"
    ></g:select>
    <g:select name="site" id="site" from=""></g:select>
</form>
     */
}
