package io.github.wjur.args

class UnknownKeysException extends Exception {
    private final Collection unknownKeys

    UnknownKeysException(Collection unknownKeys) {
        super("Unknown keys: $unknownKeys")
        this.unknownKeys = unknownKeys
    }

    Collection getUnknownKeys() {
        return unknownKeys
    }
}
