; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [2 x i8]c"+\00", align 1
@.str2 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str3 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str24 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str4 = private unnamed_addr constant [2 x i8]c"-\00", align 1
@.str5 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str6 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str25 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str7 = private unnamed_addr constant [2 x i8]c"*\00", align 1
@.str8 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str9 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str26 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str10 = private unnamed_addr constant [2 x i8]c"/\00", align 1
@.str11 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str12 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str27 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str13 = private unnamed_addr constant [2 x i8]c"+\00", align 1
@.str14 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str15 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str28 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str16 = private unnamed_addr constant [4 x i8]c"* (\00", align 1
@.str17 = private unnamed_addr constant [2 x i8]c"+\00", align 1
@.str18 = private unnamed_addr constant [5 x i8]c") = \00", align 1
@.str19 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str29 = private unnamed_addr constant [17 x i8]c"%d%s%d%s%d%s%d%s\00", align 1
@.str20 = private unnamed_addr constant [4 x i8]c"*  \00", align 1
@.str21 = private unnamed_addr constant [2 x i8]c"+\00", align 1
@.str22 = private unnamed_addr constant [5 x i8]c"  = \00", align 1
@.str23 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str30 = private unnamed_addr constant [17 x i8]c"%d%s%d%s%d%s%d%s\00", align 1

define void @main() {
entry:
	%0 = getelementptr inbounds [2 x i8], [2 x i8]* @.str1, i32 0, i32 0
	%1 = getelementptr inbounds [4 x i8], [4 x i8]* @.str2, i32 0, i32 0
	%2 = add i32 5, 7
	%3 = getelementptr inbounds [2 x i8], [2 x i8]* @.str3, i32 0, i32 0
	%4 = getelementptr inbounds [13 x i8], [13 x i8]* @.str24, i32 0, i32 0
	%5 = call i32 (i8*, ...) @printf(i8* %4, i32 5, i8* %0, i32 7, i8* %1, i32 %2, i8* %3)
	%6 = getelementptr inbounds [2 x i8], [2 x i8]* @.str4, i32 0, i32 0
	%7 = getelementptr inbounds [4 x i8], [4 x i8]* @.str5, i32 0, i32 0
	%8 = sub i32 5, 7
	%9 = getelementptr inbounds [2 x i8], [2 x i8]* @.str6, i32 0, i32 0
	%10 = getelementptr inbounds [13 x i8], [13 x i8]* @.str25, i32 0, i32 0
	%11 = call i32 (i8*, ...) @printf(i8* %10, i32 5, i8* %6, i32 7, i8* %7, i32 %8, i8* %9)
	%12 = getelementptr inbounds [2 x i8], [2 x i8]* @.str7, i32 0, i32 0
	%13 = getelementptr inbounds [4 x i8], [4 x i8]* @.str8, i32 0, i32 0
	%14 = mul i32 5, 7
	%15 = getelementptr inbounds [2 x i8], [2 x i8]* @.str9, i32 0, i32 0
	%16 = getelementptr inbounds [13 x i8], [13 x i8]* @.str26, i32 0, i32 0
	%17 = call i32 (i8*, ...) @printf(i8* %16, i32 5, i8* %12, i32 7, i8* %13, i32 %14, i8* %15)
	%18 = getelementptr inbounds [2 x i8], [2 x i8]* @.str10, i32 0, i32 0
	%19 = getelementptr inbounds [4 x i8], [4 x i8]* @.str11, i32 0, i32 0
	%20 = udiv i32 5, 7
	%21 = getelementptr inbounds [2 x i8], [2 x i8]* @.str12, i32 0, i32 0
	%22 = getelementptr inbounds [13 x i8], [13 x i8]* @.str27, i32 0, i32 0
	%23 = call i32 (i8*, ...) @printf(i8* %22, i32 5, i8* %18, i32 7, i8* %19, i32 %20, i8* %21)
	%24 = getelementptr inbounds [2 x i8], [2 x i8]* @.str13, i32 0, i32 0
	%25 = getelementptr inbounds [4 x i8], [4 x i8]* @.str14, i32 0, i32 0
	%26 = add i32 5, 1
	%27 = getelementptr inbounds [2 x i8], [2 x i8]* @.str15, i32 0, i32 0
	%28 = getelementptr inbounds [13 x i8], [13 x i8]* @.str28, i32 0, i32 0
	%29 = call i32 (i8*, ...) @printf(i8* %28, i32 5, i8* %24, i32 1, i8* %25, i32 %26, i8* %27)
	%30 = getelementptr inbounds [4 x i8], [4 x i8]* @.str16, i32 0, i32 0
	%31 = getelementptr inbounds [2 x i8], [2 x i8]* @.str17, i32 0, i32 0
	%32 = getelementptr inbounds [5 x i8], [5 x i8]* @.str18, i32 0, i32 0
	%33 = add i32 5, 7
	%34 = mul i32 5, %33
	%35 = getelementptr inbounds [2 x i8], [2 x i8]* @.str19, i32 0, i32 0
	%36 = getelementptr inbounds [17 x i8], [17 x i8]* @.str29, i32 0, i32 0
	%37 = call i32 (i8*, ...) @printf(i8* %36, i32 5, i8* %30, i32 5, i8* %31, i32 7, i8* %32, i32 %34, i8* %35)
	%38 = getelementptr inbounds [4 x i8], [4 x i8]* @.str20, i32 0, i32 0
	%39 = getelementptr inbounds [2 x i8], [2 x i8]* @.str21, i32 0, i32 0
	%40 = getelementptr inbounds [5 x i8], [5 x i8]* @.str22, i32 0, i32 0
	%41 = mul i32 5, 5
	%42 = add i32 %41, 7
	%43 = getelementptr inbounds [2 x i8], [2 x i8]* @.str23, i32 0, i32 0
	%44 = getelementptr inbounds [17 x i8], [17 x i8]* @.str30, i32 0, i32 0
	%45 = call i32 (i8*, ...) @printf(i8* %44, i32 5, i8* %38, i32 5, i8* %39, i32 7, i8* %40, i32 %42, i8* %43)
	ret void 
}


