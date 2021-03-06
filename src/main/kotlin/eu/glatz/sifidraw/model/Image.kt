package eu.glatz.sifidraw.model

import org.springframework.data.annotation.Transient

class Image(id: String, name: String) : IImage(id, name) {
    var layers: MutableList<Layer> = mutableListOf()
    @Transient
    var data: String = ""

    @Transient
    open var fileExtension : String = ""

    var width = 0

    var height = 0

    var hasLayerData = false
    
    init {
        type = "img"
    }
}
