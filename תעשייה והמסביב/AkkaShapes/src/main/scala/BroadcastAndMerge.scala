package main.scala

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, ClosedShape}
import akka.stream.scaladsl.{Broadcast, Flow, GraphDSL, Merge, RunnableGraph, Sink}
import akka.stream.scaladsl.Source


object BroadcastAndMerge extends App {

  val source = Source(1 to 10)
  val sink = Sink.foreach(println)


  val g = RunnableGraph.fromGraph(GraphDSL.create() { implicit builder: GraphDSL.Builder[NotUsed] =>
    import GraphDSL.Implicits._

    val broadcast = builder.add(Broadcast[Int](2))
    val merge = builder.add(Merge[Int](2))

    val f1 = Flow.apply[Int]
    val f2 = Flow[Int].map(ele => { println(s"Flow2 = $ele"); ele })
    val f4 = Flow[Int].map(ele => { println(s"Flow4 = $ele"); ele })

    source ~> f1 ~> broadcast ~> f2 ~> merge ~> sink
                    broadcast ~> f4 ~> merge
    ClosedShape
  })
  implicit val system = ActorSystem("MyActorSystem") //  heavy data stracture that allocate some threads under the hood
  implicit val materializer = ActorMaterializer // enable akka code to run
  g.run()
}
