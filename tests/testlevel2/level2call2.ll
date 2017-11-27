; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [7 x i8]c"1+3 = \00", align 1
@.str2 = private unnamed_addr constant [5 x i8]c"%s%d\00", align 1

define void @main() {
; <label>:0
	%1 = getelementptr inbounds [7 x i8], [7 x i8]* @.str1, i32 0, i32 0
	%2 = call i32 @plus(i32 1, i32 3)
	%3 = getelementptr inbounds [5 x i8], [5 x i8]* @.str2, i32 0, i32 0
	%4 = call i32 (i8*, ...) @printf(i8* %3, i8* %1, i32 %2)
	ret void 
}

define i32 @plus(i32, i32) {
; <label>:2
	%3 = alloca i32
	%4 = alloca i32
	%5 = alloca i32
	store i32 %0, i32* %3
	store i32 %1, i32* %4
	%6 = load i32, i32* %3
	%7 = load i32, i32* %4
	%8 = add i32 %6, %7
	store i32 %8, i32* %5
	%9 = load i32, i32* %5
	ret i32 %9
}


