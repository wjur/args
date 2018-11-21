package io.github.wjur.args

import java.time.ZonedDateTime

class DomainObjectTestBuilder {
    private DomainObjectTestBuilder() {}

    private static final Map defaults = [
            id: 5L,
            name: 'domain-object-1',
            createdAt: ZonedDateTime.parse('2018-11-21T19:53:43Z')
    ]

    static DomainObject domainObject(Map overrides = [:]) {
        def args = Args.args(defaults, overrides)
        return new DomainObject(
                args.id as Long,
                args.name as String,
                args.createdAt instanceof String ? ZonedDateTime.parse(args.createdAt as String) : args.createdAt as ZonedDateTime
        )
    }
}
