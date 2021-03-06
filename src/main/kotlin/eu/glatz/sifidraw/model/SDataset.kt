package eu.glatz.sifidraw.model

import com.fasterxml.jackson.annotation.JsonView
import eu.glatz.sifidraw.util.JsonViews
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
class SDataset : SEntity() {

    companion object {
        @Transient
        @JvmStatic
        val SEQUENCE_NAME: String = "dataset_sequence"
    }

    @JsonView(JsonViews.AllDatasetData::class, JsonViews.OnlyDatasetData::class)
    @DBRef(lazy = true)
    var images = mutableListOf<SAImage>()
}