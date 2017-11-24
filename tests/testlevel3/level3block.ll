; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str3 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str4 = private unnamed_addr constant [3 x i8]c"%d\00", align 1
@.str1 = private unnamed_addr constant [22 x i8]c"y a l'interieur vaut \00", align 1
@.str5 = private unnamed_addr constant [5 x i8]c"%s%d\00", align 1
@.str2 = private unnamed_addr constant [38 x i8]c", mais a l'exterieur du bloc il vaut \00", align 1
@.str6 = private unnamed_addr constant [5 x i8]c"%s%d\00", align 1

define void @main() {
entry:
	%0 = alloca i32
	%1 = getelementptr inbounds [3 x i8], [3 x i8]* @.str3, i32 0, i32 0
	%2 = call i32 (i8*, ...) @scanf(i8* %1, i32* %0)
	%3 = alloca i32
	%4 = getelementptr inbounds [3 x i8], [3 x i8]* @.str4, i32 0, i32 0
	%5 = call i32 (i8*, ...) @scanf(i8* %4, i32* %3)
	%6 = getelementptr inbounds [22 x i8], [22 x i8]* @.str1, i32 0, i32 0
	%7 = load i32, i32* %3
	%8 = getelementptr inbounds [5 x i8], [5 x i8]* @.str5, i32 0, i32 0
	%9 = call i32 (i8*, ...) @printf(i8* %8, i8* %6, i32 %7)
	%10 = getelementptr inbounds [38 x i8], [38 x i8]* @.str2, i32 0, i32 0
	%11 = load i32, i32* %0
	%12 = getelementptr inbounds [5 x i8], [5 x i8]* @.str6, i32 0, i32 0
	%13 = call i32 (i8*, ...) @printf(i8* %12, i8* %10, i32 %11)
	ret void 
}


