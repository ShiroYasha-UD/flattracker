package dev.shiroyasha.flat_tracker.listing

import jakarta.validation.Valid
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import java.math.BigDecimal
import java.time.Instant


enum class ListingType {
    RENT,
    SALE
}

data class ScrapedListing(
    @field:NotBlank
    val externalId: String,

    val type: ListingType,

    @field:NotBlank
    val url: String,

    @field:Min(1)
    @field:Max(23)
    val district: Int,

    @field:DecimalMin("1.0")
    val sizeM2: BigDecimal,

    @field:Positive
    val priceHuf: Long
)

data class ListingBatchRequest(
    val scrapedAt: Instant,

    @field:NotEmpty
    @field:Size(max = 500)
    @field:Valid
    val listings:
        List<ScrapedListing>,
)