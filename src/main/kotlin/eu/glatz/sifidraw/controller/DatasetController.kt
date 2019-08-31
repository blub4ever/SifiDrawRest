package eu.glatz.sifidraw.controller

import eu.glatz.sifidraw.config.ProjectSettings
import eu.glatz.sifidraw.model.Dataset
import eu.glatz.sifidraw.model.ProjectData
import eu.glatz.sifidraw.service.DatasetService
import eu.glatz.sifidraw.service.ProjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.io.File
import java.nio.charset.Charset
import java.util.*

@CrossOrigin
@RestController
class DatasetController @Autowired constructor(
        private val datasetService: DatasetService,
        private val projectSettings: ProjectSettings) {

    @GetMapping("/dataset/{id}")
    fun getDataset(@PathVariable id: String): Dataset {
        return datasetService.getDataset(id);
    }

    @PostMapping("/dataset/new/{id}")
    fun createDataset(@PathVariable id: String): Boolean {
        val f = File(projectSettings.dir, String(Base64.getDecoder().decode(id), Charset.forName("UTF-8")))
        println("creating dir ${f.absolutePath}")
        return f.mkdir();
    }

}
