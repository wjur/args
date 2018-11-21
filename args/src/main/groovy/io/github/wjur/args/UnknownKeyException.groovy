package io.github.wjur.args

class UnknownKeyException extends Exception {

    private final String unknownKey

    UnknownKeyException(String unknownKey) {
        super("Unknown key: '$unknownKey'")
        this.unknownKey = unknownKey
    }

    String getUnknownKey() {
        return unknownKey
    }
}
