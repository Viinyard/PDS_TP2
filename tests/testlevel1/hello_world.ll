; text > Hello World
; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins

@"Hello World1" = global [12 x i8] c"Hello World\00"


define i32 @main() {
	call i32 (i8*, ...) @printf(i8 Hello World)
}


