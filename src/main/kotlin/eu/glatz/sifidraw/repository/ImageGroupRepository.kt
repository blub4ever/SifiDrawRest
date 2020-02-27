package eu.glatz.sifidraw.repository

import eu.glatz.sifidraw.model.FilterSet
import eu.glatz.sifidraw.model.ImageGroup
import org.springframework.data.mongodb.repository.MongoRepository

interface ImageGroupRepository  : MongoRepository<ImageGroup, String> {
}