; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [14 x i8]c"\0A Hanoi avec \00", align 1
@.str2 = private unnamed_addr constant [11 x i8]c" disques\0A\0A\00", align 1
@.str3 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str4 = private unnamed_addr constant [14 x i8]c"\0A\0AHanoi avec \00", align 1
@.str5 = private unnamed_addr constant [11 x i8]c" disques\0A\0A\00", align 1
@.str6 = private unnamed_addr constant [7 x i8]c"%s%d%s\00", align 1
@.str7 = private unnamed_addr constant [23 x i8]c"Deplacer un disque de \00", align 1
@.str8 = private unnamed_addr constant [4 x i8]c" a \00", align 1
@.str9 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str10 = private unnamed_addr constant [11 x i8]c"%s%d%s%d%s\00", align 1

define void @main() {
; <label>:0
	%1 = alloca i32
	%2 = alloca i32
	store i32 3, i32* %1
	%3 = getelementptr inbounds [14 x i8], [14 x i8]* @.str1, i32 0, i32 0
	%4 = load i32, i32* %1
	%5 = getelementptr inbounds [11 x i8], [11 x i8]* @.str2, i32 0, i32 0
	%6 = getelementptr inbounds [7 x i8], [7 x i8]* @.str3, i32 0, i32 0
	%7 = call i32 (i8*, ...) @printf(i8* %6, i8* %3, i32 %4, i8* %5)
	%8 = load i32, i32* %1
	%9 = call i32 @hanoi(i32 %8, i32 1, i32 3, i32 2)
	store i32 %9, i32* %2
	store i32 4, i32* %1
	%10 = getelementptr inbounds [14 x i8], [14 x i8]* @.str4, i32 0, i32 0
	%11 = load i32, i32* %1
	%12 = getelementptr inbounds [11 x i8], [11 x i8]* @.str5, i32 0, i32 0
	%13 = getelementptr inbounds [7 x i8], [7 x i8]* @.str6, i32 0, i32 0
	%14 = call i32 (i8*, ...) @printf(i8* %13, i8* %10, i32 %11, i8* %12)
	%15 = load i32, i32* %1
	%16 = call i32 @hanoi(i32 %15, i32 1, i32 3, i32 2)
	store i32 %16, i32* %2
	ret void 
}

define i32 @hanoi(i32, i32, i32, i32) {
; <label>:4
	%5 = alloca i32
	%6 = alloca i32
	%7 = alloca i32
	%8 = alloca i32
	%9 = alloca i32
	%10 = alloca i32
	store i32 %0, i32* %5
	store i32 %1, i32* %6
	store i32 %2, i32* %7
	store i32 %3, i32* %8
	%11 = load i32, i32* %5
	%12 = icmp ne i32 %11, 0
	br i1 %12, label %13, label %33
; <label>:13
	%14 = load i32, i32* %5
	%15 = sub i32 %14, 1
	%16 = load i32, i32* %6
	%17 = load i32, i32* %8
	%18 = load i32, i32* %7
	%19 = call i32 @hanoi(i32 %15, i32 %16, i32 %17, i32 %18)
	store i32 %19, i32* %10
	%20 = getelementptr inbounds [23 x i8], [23 x i8]* @.str7, i32 0, i32 0
	%21 = load i32, i32* %6
	%22 = getelementptr inbounds [4 x i8], [4 x i8]* @.str8, i32 0, i32 0
	%23 = load i32, i32* %7
	%24 = getelementptr inbounds [2 x i8], [2 x i8]* @.str9, i32 0, i32 0
	%25 = getelementptr inbounds [11 x i8], [11 x i8]* @.str10, i32 0, i32 0
	%26 = call i32 (i8*, ...) @printf(i8* %25, i8* %20, i32 %21, i8* %22, i32 %23, i8* %24)
	%27 = load i32, i32* %5
	%28 = sub i32 %27, 1
	%29 = load i32, i32* %8
	%30 = load i32, i32* %7
	%31 = load i32, i32* %6
	%32 = call i32 @hanoi(i32 %28, i32 %29, i32 %30, i32 %31)
	store i32 %32, i32* %10
	br label %33
; <label>:33
	store i32 1, i32* %9
	%34 = load i32, i32* %9
	ret i32 %34
}


