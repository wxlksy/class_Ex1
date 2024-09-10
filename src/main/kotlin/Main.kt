import kotlin.math.abs

data class Point(val x: Double, val y: Double)
class Treugol(val p1: Point, val p2: Point, val p3: Point)
{

    fun Proverka(point: Point): Boolean
    {
        val a = calcA(p1, p2, p3)
        val a1 = calcA(point, p2, p3)
        val a2 = calcA(p1, point, p3)
        val a3 = calcA(p1, p2, point)

        return abs(a - (a1 + a2 + a3)) < 1e-9
    }

    private fun calcA(p1: Point, p2: Point, p3: Point): Double
    {
        return 0.5 * abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)))
    }
}

fun main()
{
    try
    {
        println("Введите координаты первой вершины треугольника:")

        val p1 = readP()

        println("Введите координаты второй вершины треугольника:")

        val p2 = readP()

        println("Введите координаты третьей вершины треугольника:")

        val p3 = readP()
        val treugol = Treugol(p1, p2, p3)

        println("Введите координаты точки:")

        val point = readP()

        if (treugol.Proverka(point))
        {
            println("Точка внутри")
        }

        else
        {
            println("Точка вне")
        }
    }

    catch (e: NumberFormatException)
    {
        println("Ошибка ввода")
    }
}

fun readP(): Point
{
    val s = readLine()?.split(" ") ?: throw NumberFormatException()

    if (s.size != 2)
    {
        throw NumberFormatException()
    }

    val x = s[0].toDouble()
    val y = s[1].toDouble()

    return Point(x, y)
}