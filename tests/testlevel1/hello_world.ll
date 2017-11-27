; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [12 x i8]c"Hello World\00", align 1
@.str2 = private unnamed_addr constant [3 x i8]c"%s\00", align 1

define void @main() {
; <label>:0
	%1 = getelementptr inbounds [12 x i8], [12 x i8]* @.str1, i32 0, i32 0
	%2 = getelementptr inbounds [3 x i8], [3 x i8]* @.str2, i32 0, i32 0
	%3 = call i32 (i8*, ...) @printf(i8* %2, i8* %1)
	ret void 
}


