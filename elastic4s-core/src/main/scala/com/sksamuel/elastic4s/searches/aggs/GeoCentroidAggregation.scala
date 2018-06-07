package com.sksamuel.elastic4s.searches.aggs

import com.sksamuel.elastic4s.ValueType
import com.sksamuel.elastic4s.script.Script
import com.sksamuel.exts.OptionImplicits._

case class GeoCentroidAggregation(name: String,
                                  field: Option[String] = None,
                                  format: Option[String] = None,
                                  missing: Option[AnyRef] = None,
                                  valueType: Option[ValueType] = None,
                                  script: Option[Script] = None,
                                  subaggs: Seq[AbstractAggregation] = Nil,
                                  metadata: Map[String, AnyRef] = Map.empty)
    extends Aggregation {

  type T = GeoCentroidAggregation

  def field(field: String): T            = copy(field = field.some)
  def format(format: String): T          = copy(format = format.some)
  def missing(missing: AnyRef): T        = copy(missing = missing.some)
  def valueType(valueType: ValueType): T = copy(valueType = valueType.some)
  def script(script: Script): T          = copy(script = script.some)

  override def subAggregations(aggs: Iterable[AbstractAggregation]): T = copy(subaggs = aggs.toSeq)
  override def metadata(map: Map[String, AnyRef]): T                   = copy(metadata = map)
}