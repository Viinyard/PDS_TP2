; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str2 = private unnamed_addr constant [18 x i8]c"Le nombre lu est \00", align 1
@.str3 = private unnamed_addr constant [5 x i8]c"%s%d\00", align 1

define void @main() {
; <label>:0
	%1 = alloca i32
	%2 = getelementptr inbounds [3 x i8], [3 x i8]* @.str1, i32 0, i32 0
	%3 = call i32 (i8*, ...) @scanf(i8* %2, i32* %1)
	%4 = getelementptr inbounds [18 x i8], [18 x i8]* @.str2, i32 0, i32 0
	%5 = load i32, i32* %1
	%6 = getelementptr inbounds [5 x i8], [5 x i8]* @.str3, i32 0, i32 0
	%7 = call i32 (i8*, ...) @printf(i8* %6, i8* %4, i32 %5)
	ret void 
}


