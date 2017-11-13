; Target
target triple = "x86_64-apple-macosx10.12.0"
; External declaration of the printf function
declare i32 @printf(i8* noalias nocapture, ...)

; Actual code begins



define i32 @main() {
	%x =  alloca i32
	%y =  alloca i32
	%z =  alloca i32
	store i32 4, i32* %x
	store i32 8, i32* %y
	%tmp1 = load i32, i32* %x
	%tmp2 = load i32, i32* %y
	%tmp3 = mul i32 %tmp1, %tmp2
	%tmp4 = add i32 %tmp3, 10
	store i32 %tmp4, i32* %z
	%tmp5 = load i32, i32* %z
	%tmp6 = mul i32 %tmp5, 2
	%tmp7 = sub i32 %tmp6, 42
	ret i32 %tmp7
}


