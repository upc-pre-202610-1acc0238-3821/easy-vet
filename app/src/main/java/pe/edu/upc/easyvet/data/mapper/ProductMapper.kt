package pe.edu.upc.easyvet.data.mapper

import pe.edu.upc.easyvet.data.local.ProductEntity
import pe.edu.upc.easyvet.data.remote.ProductDto
import pe.edu.upc.easyvet.domain.model.Product

fun ProductDto.toEntity(): ProductEntity {
    return ProductEntity(
        id = this.id,
        name = this.title,
        price = this.price,
        description = this.description,
        image = this.image
    )
}

fun ProductDto.toDomain(): Product {
    return Product(
        id = this.id,
        name = this.title,
        price = this.price,
        description = this.description,
        image = this.image
    )
}

fun ProductEntity.toDomain(): Product {
    return Product(
        id = this.id,
        name = this.name,
        price = this.price,
        description = this.description,
        image = this.image
    )
}