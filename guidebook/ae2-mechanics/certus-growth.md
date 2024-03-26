---
navigation:
  parent: ae2-mechanics/ae2-mechanics-index.md
  title: 赛特斯石英生长机制
  icon: quartz_cluster
---

# 赛特斯石英生长机制

## 基本上就是从入门页面复制粘贴过来的

<GameScene zoom="6" background="transparent">
<ImportStructure src="../assets/assemblies/budding_certus_1.snbt" />
</GameScene>

赛特斯石英芽会从 [赛特斯石英母岩](../items-blocks-machines/budding_certus.md) 中萌发，与紫水晶类似。
如果破坏一个尚未长成的石英芽，它将掉落一个 <ItemLink id="certus_quartz_dust" />，不受时运魔咒影响。
如果破坏一簇完全长成的石英簇，则会掉落四个 <ItemLink id="certus_quartz_crystal" />，时运魔咒会增加掉落数量。

赛特斯石英母岩有四个损坏等级：无瑕、有瑕疵、开裂和损坏，你可以在 [陨石](../ae2-mechanics/meteorites.md) 中找到它们。

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/budding_blocks.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

每当一个石英芽生长到另一个阶段，石英母岩就有几率退化一级，最终变成一个普通的石英块。
只要将石英母岩（或石英块）与一个或多个 <ItemLink id="charged_certus_quartz_crystal" /> 一起扔到水中，
就能修复它们（或者生成新的石英母岩）。

<RecipeFor id="damaged_budding_quartz" />

无瑕的赛特斯石英母岩不会退化，并能无限生成赛特斯石英。
不过，它们无法制作或用镐采集，即使使用精准采集。(不过它们*可以*用 [空间存储](../ae2-mechanics/spatial-io.md) 移动)

就赛特斯石英芽本身而言，其生长速度非常缓慢。
幸运的是，当 <ItemLink id="growth_accelerator" /> 放在石英母岩旁边时，会大大加快这一过程。当务之急是建造几个这样的装置。

<GameScene zoom="4" background="transparent">
  <ImportStructure src="../assets/assemblies/budding_certus_2.snbt" />
  <IsometricCamera yaw="195" pitch="30" />
</GameScene>

如果你没有足够的石英来制作 <ItemLink id="energy_acceptor" /> 或 <ItemLink id="vibration_chamber" />，
你可以制作一个 <ItemLink id="crank" /> 并将其安装在催生器的末端。

自动收获赛特斯石英请 [参阅此处](../example-setups/simple-certus-farm.md)。