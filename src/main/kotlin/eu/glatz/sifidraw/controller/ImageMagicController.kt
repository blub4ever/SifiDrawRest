package eu.glatz.sifidraw.controller

import eu.glatz.sifidraw.model.Image
import eu.glatz.sifidraw.service.ImageMagicService
import eu.glatz.sifidraw.util.ImageUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.nio.charset.Charset
import java.util.*

@CrossOrigin
@RestController
class ImageMagicController @Autowired constructor(
        private val imageMagicService: ImageMagicService) {

    @PostMapping("/magic/{command}")
    fun modifyImageData(@RequestBody image: Image, @PathVariable command: String): Image {
        println("put " + command)
        val command = String(Base64.getDecoder().decode(command), Charset.forName("UTF-8"))

        val file = ImageUtil.writeUniqueBase64Img(imageMagicService.dir, imageMagicService.file, image)
        val resultFile = imageMagicService.runImageMagic(file, command);
        val result = imageMagicService.getConvertedImage(resultFile);

        return if (result != "") {
            image.data = result;
            image.id = Base64.getEncoder().encodeToString(resultFile.name.toString().toByteArray())
            image;
        } else {
            Image("error", "")
        }

        return Image("","")
    }
}
