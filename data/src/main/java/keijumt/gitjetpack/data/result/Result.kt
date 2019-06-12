package keijumt.gitjetpack.data.result

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

sealed class Result<out R> {
    data class Success<out R>(val data: R) : Result<R>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

fun <R> Result<R>.toSuccess() = (this as Result.Success)

@UseExperimental(ExperimentalContracts::class)
fun <R> Result<R>.isError(): Boolean {
    contract {
        returns(true) implies (this@isError is Result.Error)
    }

    return this is Result.Error
}