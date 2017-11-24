; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str5 = private unnamed_addr constant [3 x i8]c"%s\00", align 1
@.str2 = private unnamed_addr constant [6 x i8]c"^2 + \00", align 1
@.str6 = private unnamed_addr constant [5 x i8]c"%d%s\00", align 1
@.str3 = private unnamed_addr constant [7 x i8]c"1^2 = \00", align 1
@.str4 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str7 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1

define void @main() {
entry:
	%0 = alloca i32
	%1 = alloca i32
	%2 = alloca i32
	store i32 5, i32* %0
	store i32 0, i32* %2
	%3 = load i32, i32* %0
	store i32 %3, i32* %1
	br label %entry1
entry1:
	%4 = load i32, i32* %1
	%5 = icmp ne i32 %4, 0
	br i1 %5, label %do2, label %done3
do2:
	%6 = load i32, i32* %2
	%7 = load i32, i32* %1
	%8 = load i32, i32* %1
	%9 = mul i32 %7, %8
	%10 = add i32 %6, %9
	store i32 %10, i32* %2
	%11 = load i32, i32* %1
	%12 = sub i32 %11, 1
	store i32 %12, i32* %1
	br label %entry1
done3:
	%13 = getelementptr inbounds [2 x i8], [2 x i8]* @.str1, i32 0, i32 0
	%14 = getelementptr inbounds [3 x i8], [3 x i8]* @.str5, i32 0, i32 0
	%15 = call i32 (i8*, ...) @printf(i8* %14, i8* %13)
	%16 = load i32, i32* %0
	store i32 %16, i32* %1
	br label %entry4
entry4:
	%17 = load i32, i32* %1
	%18 = sub i32 %17, 1
	%19 = icmp ne i32 %18, 0
	br i1 %19, label %do5, label %done6
do5:
	%20 = load i32, i32* %1
	%21 = getelementptr inbounds [6 x i8], [6 x i8]* @.str2, i32 0, i32 0
	%22 = getelementptr inbounds [5 x i8], [5 x i8]* @.str6, i32 0, i32 0
	%23 = call i32 (i8*, ...) @printf(i8* %22, i32 %20, i8* %21)
	%24 = load i32, i32* %1
	%25 = sub i32 %24, 1
	store i32 %25, i32* %1
	br label %entry4
done6:
	%26 = getelementptr inbounds [7 x i8], [7 x i8]* @.str3, i32 0, i32 0
	%27 = load i32, i32* %2
	%28 = getelementptr inbounds [2 x i8], [2 x i8]* @.str4, i32 0, i32 0
	%29 = getelementptr inbounds [7 x i8], [7 x i8]* @.str7, i32 0, i32 0
	%30 = call i32 (i8*, ...) @printf(i8* %29, i8* %26, i32 %27, i8* %28)
	ret void 
}


