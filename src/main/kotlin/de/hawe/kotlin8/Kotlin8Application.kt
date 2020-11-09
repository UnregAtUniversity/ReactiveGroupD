package de.hawe.kotlin8

import ch.qos.logback.core.db.dialect.MySQLDialect
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.lang.RuntimeException

@SpringBootApplication
class Kotlin8Application

fun main(args: Array<String>) {
    runApplication<Kotlin8Application>(*args)
//	fluxTest()
//	fluxConcat()
    //fluxWithRange()
//	fluxTakeLast()
    //fluxMap()
//	filterList()
//twoMonoToFlux()
 //   val s = MySequenz()
 //   s.sequenzenTest()

}

fun fluxTest() {

    val flux = Flux.just("A", "B", "C")
    flux.subscribe { data -> println(data) }

}

fun fluxConcat() {
    Flux.just("A", "B", "C")
            .concatWith(Flux.just("X", "Y", "Z"))
            .log()
            .subscribe { data -> println(data) }
}

fun fluxWithRange() {
    Flux.range(3, 7)
            .subscribe { data -> println(data) }
}

fun fluxTakeLast() {
    Flux.range(3, 7)
            .takeLast(2)
            .subscribe { data -> println(data) }
}


fun monoTest() {
    Mono.just("A")
            .log()
            .subscribe()
}


fun fluxMap() {

    Flux.just(1, 2, 3, 4)
            .log()
            .map { i -> i * 2 }
            .subscribe { data -> println(data) }
}

fun filterList() {
    val L = listOf("A", "B", "C")
    Flux.fromIterable(L)
            .filter { l -> l.startsWith("A") }
            .log()
            .subscribe { data -> println(data) }
}


fun twoMonoToFlux() {
    val mono1 = Mono.just("A")
    val mono2 = Mono.just("X")

    Flux.concat(mono1, mono2)
            .log()
            .subscribe { data -> println(data) }
}



