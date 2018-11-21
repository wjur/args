package io.github.wjur.args

class Args  {

    private final Map values

    private Args(Map defaults, Map overrides) {
        this.values = defaults + overrides
    }

    def getProperty(String property){
        def v
        if ((v = values[property]) != null || values.containsKey(property)) {
            return v
        } else {
            throw new UnknownKeyException(property)
        }
    }

    static Args args(Map defaults, Map overrides = [:]) {
        if (defaults == null) {
            throw new NullPointerException("Args 'defaults' cannot be null")
        }
        if (overrides == null) {
            throw new NullPointerException("Args 'overrides' cannot be null")
        }

        def unknownKeys = overrides.keySet() - defaults.keySet()
        if (!unknownKeys.isEmpty()) {
            throw new UnknownKeysException(unknownKeys)
        }
        return new Args(defaults, overrides)
    }
}


