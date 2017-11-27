; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)
declare i32 @scanf(i8* noalias nocapture, ...)

; Actual code begins

@.str1 = private unnamed_addr constant [2 x i8]c"+\00", align 1
@.str2 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str3 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str4 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str5 = private unnamed_addr constant [2 x i8]c"-\00", align 1
@.str6 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str7 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str8 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str9 = private unnamed_addr constant [2 x i8]c"*\00", align 1
@.str10 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str11 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str12 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str13 = private unnamed_addr constant [2 x i8]c"/\00", align 1
@.str14 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str15 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str16 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str17 = private unnamed_addr constant [2 x i8]c"+\00", align 1
@.str18 = private unnamed_addr constant [4 x i8]c" = \00", align 1
@.str19 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str20 = private unnamed_addr constant [13 x i8]c"%d%s%d%s%d%s\00", align 1
@.str21 = private unnamed_addr constant [4 x i8]c"* (\00", align 1
@.str22 = private unnamed_addr constant [2 x i8]c"+\00", align 1
@.str23 = private unnamed_addr constant [5 x i8]c") = \00", align 1
@.str24 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str25 = private unnamed_addr constant [17 x i8]c"%d%s%d%s%d%s%d%s\00", align 1
@.str26 = private unnamed_addr constant [4 x i8]c"*  \00", align 1
@.str27 = private unnamed_addr constant [2 x i8]c"+\00", align 1
@.str28 = private unnamed_addr constant [5 x i8]c"  = \00", align 1
@.str29 = private unnamed_addr constant [2 x i8]c"\0A\00", align 1
@.str30 = private unnamed_addr constant [17 x i8]c"%d%s%d%s%d%s%d%s\00", align 1

define void @main() {
; <label>:0
	call void @expr(i32 1, i32 3)
	call void @expr(i32 5, i32 2)
	ret void 
}

define void @expr(i32, i32) {
; <label>:2
	%3 = alloca i32
	%4 = alloca i32
	store i32 %0, i32* %3
	store i32 %1, i32* %4
	%5 = load i32, i32* %3
	%6 = getelementptr inbounds [2 x i8], [2 x i8]* @.str1, i32 0, i32 0
	%7 = load i32, i32* %4
	%8 = getelementptr inbounds [4 x i8], [4 x i8]* @.str2, i32 0, i32 0
	%9 = load i32, i32* %3
	%10 = load i32, i32* %4
	%11 = add i32 %9, %10
	%12 = getelementptr inbounds [2 x i8], [2 x i8]* @.str3, i32 0, i32 0
	%13 = getelementptr inbounds [13 x i8], [13 x i8]* @.str4, i32 0, i32 0
	%14 = call i32 (i8*, ...) @printf(i8* %13, i32 %5, i8* %6, i32 %7, i8* %8, i32 %11, i8* %12)
	%15 = load i32, i32* %3
	%16 = getelementptr inbounds [2 x i8], [2 x i8]* @.str5, i32 0, i32 0
	%17 = load i32, i32* %4
	%18 = getelementptr inbounds [4 x i8], [4 x i8]* @.str6, i32 0, i32 0
	%19 = load i32, i32* %3
	%20 = load i32, i32* %4
	%21 = sub i32 %19, %20
	%22 = getelementptr inbounds [2 x i8], [2 x i8]* @.str7, i32 0, i32 0
	%23 = getelementptr inbounds [13 x i8], [13 x i8]* @.str8, i32 0, i32 0
	%24 = call i32 (i8*, ...) @printf(i8* %23, i32 %15, i8* %16, i32 %17, i8* %18, i32 %21, i8* %22)
	%25 = load i32, i32* %3
	%26 = getelementptr inbounds [2 x i8], [2 x i8]* @.str9, i32 0, i32 0
	%27 = load i32, i32* %4
	%28 = getelementptr inbounds [4 x i8], [4 x i8]* @.str10, i32 0, i32 0
	%29 = load i32, i32* %3
	%30 = load i32, i32* %4
	%31 = mul i32 %29, %30
	%32 = getelementptr inbounds [2 x i8], [2 x i8]* @.str11, i32 0, i32 0
	%33 = getelementptr inbounds [13 x i8], [13 x i8]* @.str12, i32 0, i32 0
	%34 = call i32 (i8*, ...) @printf(i8* %33, i32 %25, i8* %26, i32 %27, i8* %28, i32 %31, i8* %32)
	%35 = load i32, i32* %3
	%36 = getelementptr inbounds [2 x i8], [2 x i8]* @.str13, i32 0, i32 0
	%37 = load i32, i32* %4
	%38 = getelementptr inbounds [4 x i8], [4 x i8]* @.str14, i32 0, i32 0
	%39 = load i32, i32* %3
	%40 = load i32, i32* %4
	%41 = udiv i32 %39, %40
	%42 = getelementptr inbounds [2 x i8], [2 x i8]* @.str15, i32 0, i32 0
	%43 = getelementptr inbounds [13 x i8], [13 x i8]* @.str16, i32 0, i32 0
	%44 = call i32 (i8*, ...) @printf(i8* %43, i32 %35, i8* %36, i32 %37, i8* %38, i32 %41, i8* %42)
	%45 = load i32, i32* %3
	%46 = getelementptr inbounds [2 x i8], [2 x i8]* @.str17, i32 0, i32 0
	%47 = getelementptr inbounds [4 x i8], [4 x i8]* @.str18, i32 0, i32 0
	%48 = load i32, i32* %3
	%49 = add i32 %48, 1
	%50 = getelementptr inbounds [2 x i8], [2 x i8]* @.str19, i32 0, i32 0
	%51 = getelementptr inbounds [13 x i8], [13 x i8]* @.str20, i32 0, i32 0
	%52 = call i32 (i8*, ...) @printf(i8* %51, i32 %45, i8* %46, i32 1, i8* %47, i32 %49, i8* %50)
	%53 = load i32, i32* %3
	%54 = getelementptr inbounds [4 x i8], [4 x i8]* @.str21, i32 0, i32 0
	%55 = load i32, i32* %3
	%56 = getelementptr inbounds [2 x i8], [2 x i8]* @.str22, i32 0, i32 0
	%57 = load i32, i32* %4
	%58 = getelementptr inbounds [5 x i8], [5 x i8]* @.str23, i32 0, i32 0
	%59 = load i32, i32* %3
	%60 = load i32, i32* %3
	%61 = load i32, i32* %4
	%62 = add i32 %60, %61
	%63 = mul i32 %59, %62
	%64 = getelementptr inbounds [2 x i8], [2 x i8]* @.str24, i32 0, i32 0
	%65 = getelementptr inbounds [17 x i8], [17 x i8]* @.str25, i32 0, i32 0
	%66 = call i32 (i8*, ...) @printf(i8* %65, i32 %53, i8* %54, i32 %55, i8* %56, i32 %57, i8* %58, i32 %63, i8* %64)
	%67 = load i32, i32* %3
	%68 = getelementptr inbounds [4 x i8], [4 x i8]* @.str26, i32 0, i32 0
	%69 = load i32, i32* %3
	%70 = getelementptr inbounds [2 x i8], [2 x i8]* @.str27, i32 0, i32 0
	%71 = load i32, i32* %4
	%72 = getelementptr inbounds [5 x i8], [5 x i8]* @.str28, i32 0, i32 0
	%73 = load i32, i32* %3
	%74 = load i32, i32* %3
	%75 = mul i32 %73, %74
	%76 = load i32, i32* %4
	%77 = add i32 %75, %76
	%78 = getelementptr inbounds [2 x i8], [2 x i8]* @.str29, i32 0, i32 0
	%79 = getelementptr inbounds [17 x i8], [17 x i8]* @.str30, i32 0, i32 0
	%80 = call i32 (i8*, ...) @printf(i8* %79, i32 %67, i8* %68, i32 %69, i8* %70, i32 %71, i8* %72, i32 %77, i8* %78)
	ret void 
}


