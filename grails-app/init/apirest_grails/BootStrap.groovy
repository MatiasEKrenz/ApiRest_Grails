package apirest_grails

class BootStrap {

    def init = { servletContext ->

        def s1 = new Site(name: "Sitio 1").save()

        def c1 = new Category(name: "Categoria 1", description: "Descripcion 1", site: s1).save() //el save lo guarda en la base de datos
        def c2 = new Category(name: "Categoria 2", description: "Descripcion 2", site: s1).save() //el save lo guarda en la base de datos
        def c3 = new Category(name: "Categoria 3", description: "Descripcion 3", site: s1).save() //el save lo guarda en la base de datos
        // no las asocio porque no las voy a usar, solo quiero que se guarden

        new Item(name: "Item 1", price: 20, category: c1, subtitle: "Subtitulo 1", imageUrl: "Url 1").save()
        new Item(name: "Item 2", price: 10, category: c1, subtitle: "Subtitulo 2", imageUrl: "Url 2").save()
        new Item(name: "Item 3", price: 100, category: c1, subtitle: "Subtitulo 3", imageUrl: "Url 3").save()
        new Item(name: "Item 4", price: 2, category: c2, subtitle: "Subtitulo 4", imageUrl: "Url 4").save()
    }
    def destroy = {
    }
}
