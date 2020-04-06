package eu.glatz.sifidraw.model

import com.fasterxml.jackson.annotation.JsonView
import eu.glatz.sifidraw.util.JsonViews
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "SImages")
class SImageGroup : SAImage() {

    @DBRef
    @JsonView(JsonViews.AllDatasetData::class, JsonViews.OnlyDatasetData::class)
    public var images = mutableListOf<SAImage>();

    init {
        type = "group"
    }
}