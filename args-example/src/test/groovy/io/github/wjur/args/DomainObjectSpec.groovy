package io.github.wjur.args

import spock.lang.Specification
import spock.lang.Unroll

import java.time.ZonedDateTime

class DomainObjectArgsExampleSpec extends Specification {

    def "should create domain object using defaults"() {
        when:
        def object = DomainObjectTestBuilder.domainObject()

        then:
        with(object) {
            id == 5L
            name == 'domain-object-1'
            createdAt == ZonedDateTime.parse('2018-11-21T19:53:43Z')
        }
    }

    def "should create domain object and override property's value"() {
        when:
        def object = DomainObjectTestBuilder.domainObject([
                name: 'a different name'
        ])

        then:
        with(object) {
            id == 5L
            name == 'a different name'
            createdAt == ZonedDateTime.parse('2018-11-21T19:53:43Z')
        }
    }

    @Unroll
    def "should create domain object and set property's value from different types"() {
        when:
        def object = DomainObjectTestBuilder.domainObject([
                createdAt: createdAtValue
        ])

        then:
        with(object) {
            id == 5L
            name == 'domain-object-1'
            createdAt == ZonedDateTime.parse('2018-04-01T00:00:00Z')
        }

        where:
        createdAtValue << ['2018-04-01T00:00:00Z', ZonedDateTime.parse('2018-04-01T00:00:00Z')]
    }

    def "should protect against typos in property names by throwing exceptions"() {
        when:
        DomainObjectTestBuilder.domainObject([
                createAt: '2018-04-01T00:00:00Z'
        ])

        then:
        def exception = thrown(UnknownKeysException)
        exception.unknownKeys.contains('createAt')
    }
}
