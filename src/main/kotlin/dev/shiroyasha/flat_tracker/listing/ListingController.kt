package dev.shiroyasha.flat_tracker.listing

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/listings")
class ListingController {

    @PostMapping("batch")
    fun ingest(@Valid @RequestBody request: ListingBatchRequest): IngestResult =
        IngestResult(received=request.listings.size)
}

data class IngestResult(val received: Int)