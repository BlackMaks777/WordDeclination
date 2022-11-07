package com.bft.task1.services

import com.github.demidko.aot.WordformMeaning.lookupForMeanings
import org.springframework.stereotype.Service

@Service
class DeclinationService : DeclinationInterface {
    override fun spell(word: String): List<String> {

        val words = lookupForMeanings(word)

        val declinations= listOf(words[0].transformations[0].toString(),
                words[0].transformations[1].toString(),
                words[0].transformations[2].toString(),
                words[0].transformations[3].toString(),
                words[0].transformations[4].toString(),
                if (words[0].transformations[5].morphology.toString()
                                .contains("тв")
                ) words[0].transformations[6].toString()
                else
                    words[0].transformations[5].toString())


        return declinations
    }
}