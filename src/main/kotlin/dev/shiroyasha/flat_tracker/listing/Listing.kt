package dev.shiroyasha.flat_tracker.listing

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.Instant

@Entity
@Table(name = "listing")
class Listing (

    @Column(nullable=false, unique = true)
    var externalId: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    var listingType: ListingType,

    var url: String,

    var district: Short,

    @Column(precision = 6, scale = 1)
    var sizeM2: BigDecimal,

    var firstSeenAt: Instant,

    var lastSeenAt: Instant,

    var removedAt: Instant? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)