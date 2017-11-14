; text > Hello
; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins

@"Hello1" = global [6 x i8] c"Hello\00"


define void @main() {
	call i32 (i8*, ...) @printf(i8 %Hello)
	ret void 
}


