package io.github.wjur.args

import spock.lang.Specification

class ArgsSpec extends Specification {

    def "should contain default values"() {
        when:
        def args = Args.args([
                foo      : 'bar'
        ])

        then:
        args.foo == 'bar'
    }

    def "should support null default values"() {
        when:
        def args = Args.args([
                foo      : null,
        ])

        then:
        args.foo == null
    }

    def "should throw when property was not defined"() {
        when:
        Args.args([:]).notDefined

        then:
        thrown(UnknownKeyException)
    }

    def "should allow override default value"() {
        when:
        def args = Args.args([
                foo: 'default',
        ], [
                foo: 'newValue'
        ])

        then:
        args.foo == 'newValue'
    }

    def "should throw when overriding a non-existing property"() {
        when:
        Args.args(['foo': 'bar'], ['non-existing': 'some-value'])

        then:
        thrown(UnknownKeysException)
    }
}
